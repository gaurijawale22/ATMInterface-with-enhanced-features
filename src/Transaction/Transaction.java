import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private double amount;
    private String type;
    private LocalDateTime timestamp;

    public Transaction(String transactionId, double amount, String type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

