package es.amplia.research.cucumber;

import static org.junit.Assert.assertTrue;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class ExtractStepDefinitions {
	
	private Account account;
	 
    @Given("^a User has £(\\d+) in their account$")
    public void a_User_has_£_in_their_current_account(int amount) {
        User user = new User();
        account = new Account();
        account.deposit(amount);
        user.setAccount(account);
 
        assertTrue("The balance is not valid.", account.getBalance() == amount);
    }
 
    @When("^£(\\d+) is extracted from the account$")
    public void £_is_extracted_from_the_account(int amount) {
        account.extract(amount);
    }
 
    @Then("^the balance should be empty$")
    public void the_balance_should_be_empty() {
    int currentBalance = account.getBalance();
        assertTrue("The expected balance was £0, but actually was: " + currentBalance, currentBalance == 0);
    }
 
    private class User {
        private Account account;
 
        public void setAccount(Account account) {
            this.account = account;
        }
    }
 
    private class Account {
        private int balance;
 
        public Account() {
            this.balance = 0;
        }
 
        public int getBalance() {
            return balance;
        }
 
        public void deposit(int amount) {
            this.balance += amount;
        }
        
        public void extract(int amount) {
            this.balance -= amount;
        }
    }
	
}
