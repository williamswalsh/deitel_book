package bcrypt;

import static java.util.Objects.requireNonNull;

import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;

/**
 * The default implementation of the {@link BcryptProvider} interface.
 *
 * <p>Uses jBCrypt from mindrot.org
 *
 * @author Evan Dooner
 * @version 30 Jun 2016
 */
public class DefaultBcryptProvider implements BcryptProvider {

    @Override
    public String hashPassword(String password, String salt) {
        requireNonNull(password, "password must not be null");
        requireNonNull(salt, "salt must not be null");

        return BCrypt.hashpw(password, salt);
    }

    @Override
    public String generateSalt(int logRounds, SecureRandom random) {
        // must be non-negative
        requireNonNull(random, "random must not be null");
        return BCrypt.gensalt(logRounds, random);
    }

    @Override
    public String generateSalt(int logRounds) {
        // must be non-negative
        return BCrypt.gensalt(logRounds);
    }

    @Override
    public String generateSalt() {
        return BCrypt.gensalt();
    }

    @Override
    public boolean checkPassword(String plaintext, String hashed) {
        requireNonNull(plaintext, "plaintext must not be null");
        requireNonNull(hashed, "hashed must not be null");

        return BCrypt.checkpw(plaintext, hashed);
    }
}