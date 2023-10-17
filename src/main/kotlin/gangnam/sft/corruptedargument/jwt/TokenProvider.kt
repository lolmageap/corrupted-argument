package gangnam.sft.corruptedargument.jwt

import com.nimbusds.jose.JOSEException
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.crypto.RSASSASigner
import com.nimbusds.jose.crypto.RSASSAVerifier
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jwt.JWTClaimsSet
import com.nimbusds.jwt.SignedJWT
import gangnam.sft.corruptedargument.domain.user.UserRepository
import gangnam.sft.corruptedargument.exception.Domain
import gangnam.sft.corruptedargument.exception.NotFoundException
import gangnam.sft.corruptedargument.util.log
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPublicKey
import java.util.*
import java.util.stream.Collectors

class TokenProvider(

    private val userRepository: UserRepository,

    @Value("\${jwt.secret}")
    private val secret: String,

    @Value("\${jwt.token-validity-in-seconds}")
    private val tokenValidityInMilliseconds: Long,

    @Value("\${jwt.token-validity-in-seconds}")
    private val refreshTokenValidityInMilliseconds: Long,
) : InitializingBean {

    private val AUTHORITIES_KEY = "auth"

    private lateinit var key: RSAKey

    override fun afterPropertiesSet() {
        val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(2048)
        val keyPair = keyPairGenerator.genKeyPair()
        this.key = RSAKey.Builder(keyPair.public as RSAPublicKey)
            .privateKey(keyPair.private)
            .keyID(secret)
            .build()
    }

    fun createToken(authentication: Authentication): String? {
        val authorities = authentication.authorities.stream()
            .map { obj: GrantedAuthority -> obj.authority }
            .collect(Collectors.joining(","))
        val now = Date().time
        val validity: Date = Date(now + this.tokenValidityInMilliseconds)

        val claimsSet = JWTClaimsSet.Builder()
            .subject(authentication.name)
            .claim(AUTHORITIES_KEY, authorities)
            .expirationTime(validity)
            .build()

        val signer = RSASSASigner(key)

        return SignedJWT(JWSHeader(JWSAlgorithm.RS512), claimsSet).run {
            sign(signer)
            serialize()
        }
    }

    fun getAuthentication(token: String?): Authentication? {
        val signedJWT = SignedJWT.parse(token)
        val verifier = RSASSAVerifier(key)

        if (signedJWT.verify(verifier)) {
            val claims = signedJWT.jwtClaimsSet
            val authorities: Collection<GrantedAuthority> = claims.getStringClaim(AUTHORITIES_KEY).split(",")
                .map { role -> SimpleGrantedAuthority(role) }
                .toList()

//            val user: User = userRepository.findByProviderId(claims.subject)
            val user = userRepository.findByEmail(claims.subject) ?: throw NotFoundException(Domain.USER)

            val authUser = AuthUser(user)
            return UsernamePasswordAuthenticationToken(authUser, token, authorities)
        } else {
            throw IllegalArgumentException("Invalid JWT token")
        }
    }

    fun validateToken(token: String?): Boolean {
        try {
            log.info("validateToken = {}", token)
            val signedJWT = SignedJWT.parse(token)
            return signedJWT.verify(RSASSAVerifier(key))
        } catch (e: JOSEException) {
            log.info("JWT 토큰이 만료되었습니다, detail: {}", e.toString())
        } catch (e: IllegalArgumentException) {
            log.info("JWT 토큰이 잘못되었습니다.")
        } catch (e: RuntimeException) {
            log.info("JWT 토큰이 만료되었습니다, detail: {}", e.toString())
        }
        return false
    }

    fun createRefreshToken(authentication: Authentication): String? {
        val authorities = authentication.authorities.stream()
            .map { obj: GrantedAuthority -> obj.authority }
            .collect(Collectors.joining(","))
        val now = Date().time
        val validity: Date = Date(now + this.refreshTokenValidityInMilliseconds)

        val claimsSet = JWTClaimsSet.Builder()
            .subject(authentication.name)
            .claim(AUTHORITIES_KEY, authorities)
            .expirationTime(validity)
            .build()

        val signer = RSASSASigner(key)

        return SignedJWT(JWSHeader(JWSAlgorithm.RS512), claimsSet).run {
            sign(signer)
            serialize()
        }
    }

}