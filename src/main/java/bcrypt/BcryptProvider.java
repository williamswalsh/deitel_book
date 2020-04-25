package bcrypt;

import java.security.SecureRandom;

/**
 * A provider for BCrypt hashing and verification.
 *
 * @author Evan Dooner
 * @version 30 Jun 2016
 */
public interface BcryptProvider {

    /**
     * Hash a password using the OpenBSD bcrypt scheme.
     *
     * @param password the password to hash
     * @param salt     the salt to hash with (perhaps generated using {@link BcryptProvider#generateSalt()})
     * @return the hashed password
     */
    String hashPassword(String password, String salt);

    /**
     * Generate a salt for use with the {@link BcryptProvider#hashPassword(String, String)} method
     *
     * @param logRounds the log2 of the number of rounds of hashing to apply
     *                  - the work factor therefore increases a 2**logRounds.
     * @param random    an instance of SecureRandom to use
     * @return an encoded salt value
     */
    String generateSalt(int logRounds, SecureRandom random);

    /**
     * Generate a salt for use with the {@link BcryptProvider#hashPassword(String, String)} method.
     *
     * @param logRounds the log2 of the number of rounds of hashing to apply
     *                  - the work factor therefore increases as 2**logRounds.
     * @return an encoded salt value
     */
    String generateSalt(int logRounds);

    /**
     * Generate a salt for use with the {@link BcryptProvider#hashPassword(String, String)} method,
     * selecting a reasonable default for the number of hashing rounds to apply.
     *
     * @return an encoded salt value
     */
    String generateSalt();

    /**
     * Check that a plaintext password matches a previously hashed one.
     *
     * @param plaintext the plaintext password to verify
     * @param hashed    the previously-hashed password
     * @return true if the passwords match, false otherwise
     */
    boolean checkPassword(String plaintext, String hashed);
}
