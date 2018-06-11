public class HouseKeeper {
  ...
  private final Clock clock;

  public HouseKeeper(Transactions transactions, Clock clock) {
    this.transactions = transactions;
    this.clock = clock;

    clock.register(() -> deleteOldTransactions());
  }

  public void start() {
    clock.start();
  }
  ...
  public void stop() {
    clock.stop();
  }
}public class HouseKeeper {
  ...
  private final Clock clock;

  public HouseKeeper(Transactions transactions, Clock clock) {
    this.transactions = transactions;
    this.clock = clock;

    clock.register(() -> deleteOldTransactions());
  }

  public void start() {
    clock.start();
  }
  ...
  public void stop() {
    clock.stop();
  }
}