package videostore.horror;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        if (daysRented <= 0) throw new IllegalArgumentException("Negative days rented");
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int calculateRenterPoints() {
        int frequentRenterPoints = 1;
        boolean isNewRelease = movie.getPriceCode() == Movie.Type.NEW_RELEASE;
        if (isNewRelease && daysRented >= 2) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public double calculatePrice() {
        switch (movie.getPriceCode()) {
            case REGULAR: return calculateRegularPrice();
			case NEW_RELEASE: return calculateNewReleasePrice();
            case CHILDRENS: return calculateChildrenPrice();
			default:
                throw new IllegalStateException("JDD: Unexpected value: " + movie.getPriceCode());
        }
    }

	private double calculateChildrenPrice() {
		double price = 1.5;
		if (daysRented > 3) {
			price += (daysRented - 3) * 1.5;
		}
		return price;
	}

	private int calculateNewReleasePrice() {
		return daysRented * 3;
	}

	private double calculateRegularPrice() {
		double price = 2;
		if (daysRented > 2) {
			price += (daysRented - 2) * 1.5;
		}
		return price;
	}
}
