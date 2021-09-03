package transaction;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import transaction.Transaction;

@Entity
class Transaction {

	private @Id @GeneratedValue Long id;
	private int date;
	private String status;
	private int amount;
	private String currency;
	private String description;

// date, status,amount, currency,description
	Transaction() {
	}

	Transaction(int date, String status, int amount, String currency, String description) {
		this.date = date;
		this.status = status;
		this.amount = amount;
		this.currency = currency;
		this.description = description;

	}

	public Long getId() {
		return this.id;
	}

	public int getDate() {
		return this.date;
	}

	public String getStatus() {
		return this.status;
	}

	public int getAmount() {
		return this.amount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public String getDescription() {
		return this.description;
	}

	

	public void setId(Long id) {
		this.id = id;
	}
	public void setDate(int date) {
	this.date= date;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Transaction))
			return false;
		Transaction transaction = (Transaction) o;
		return Objects.equals(this.id, transaction.id) 
				&& Objects.equals(this.date, transaction.date)
				&& Objects.equals(this.status, transaction.status)
				&& Objects.equals(this.amount, transaction.amount)
				&& Objects.equals(this.currency, transaction.currency)
				&& Objects.equals(this.description, transaction.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.date, this.status, this.amount, this.currency, this.description);
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", status=" + status + ", amount=" + amount + ", currency="
				+ currency + ", description=" + description + "]";
	}
}