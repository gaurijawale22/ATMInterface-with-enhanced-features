public class ATM {
    private static final int MAX_ATTEMPTS = 3;
    private Map<String, User> users;
    private User currentUser;

    public ATM() {
        users = new HashMap<>();
        // Load users from persistent storage
    }

    public boolean authenticateUser(String userId, String pin) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        
        if (user.isLocked()) {
            System.out.println("Account is locked due to multiple failed login attempts.");
            return false;
        }

        if (user.validatePin(pin)) {
            user.resetFailedAttempts();
            currentUser = user;
            return true;
        } else {
            user.incrementFailedAttempts();
            if (user.getFailedAttempts() >= MAX_ATTEMPTS) {
                user.lock();
                System.out.println("Account locked due to multiple failed login attempts.");
            }
            return false;
        }
    }
    
    // Other ATM methods...
}

