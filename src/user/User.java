import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String pinHash;
    private List<Account> accounts;
    private int failedAttempts;
    private boolean locked;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pinHash = hashPin(pin);
        this.accounts = new ArrayList<>();
        this.failedAttempts = 0;
        this.locked = false;
    }

    private String hashPin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validatePin(String pin) {
        return this.pinHash.equals(hashPin(pin));
    }

    public void incrementFailedAttempts() {
        failedAttempts++;
    }

    public void resetFailedAttempts() {
        failedAttempts = 0;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void lock() {
        locked = true;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getUserId() {
        return userId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", locked=" + locked +
                ", failedAttempts=" + failedAttempts +
                '}';
    }
}

