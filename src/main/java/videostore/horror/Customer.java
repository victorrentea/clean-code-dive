package videostore.horror;
// coding kata derived from the Video Store example in Refactoring (1 ed) by Martin Fowler

import java.util.*;

class Rental {
	private final Movie movie;
	private final int daysRented;

	public Rental(Movie movie, int daysRented) {
		if (daysRented <= 0) throw new IllegalArgumentException("Negative days rented");
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
}
class Customer {
	private final String name;
	private List<Rental> rentals = new ArrayList<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental : rentals) {
			double thisAmount = 0;
			// determine amounts for each line
			switch (rental.getMovie().getPriceCode()) {
				case REGULAR:
					thisAmount += 2;
					if (rental.getDaysRented() > 2)
						thisAmount += (rental.getDaysRented() - 2) * 1.5;
					break;
				case NEW_RELEASE:
					thisAmount += rental.getDaysRented() * 3;
					break;
				case CHILDRENS:
					thisAmount += 1.5;
					if (rental.getDaysRented() > 3)
						thisAmount += (rental.getDaysRented() - 3) * 1.5;
					break;
			}
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			boolean isNewRelease = rental.getMovie().getPriceCode() == Movie.Type.NEW_RELEASE;
			if (isNewRelease && rental.getDaysRented() >= 2) {
				frequentRenterPoints++;
			}
			// show figures line for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}
}