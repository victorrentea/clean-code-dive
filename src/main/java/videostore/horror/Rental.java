package videostore.horror;

import java.util.Map;
import java.util.function.Function;

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
        boolean isNewRelease = movie.getType() == Movie.Type.NEW_RELEASE;
        if (isNewRelease && daysRented >= 2) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

//    public double calculatePrice() {
////    	return movie.getType().computePrice(daysRented);
//		switch (movie.getType()) {
//			case REGULAR: return calculateRegularPrice();
//			case NEW_RELEASE: return calculateNewReleasePrice();
//			case CHILDRENS: return calculateChildrenPrice();
//			default:
//				throw new IllegalStateException("JDD: Unexpected value: " + movie.getType());
//		}
//
//    }
//    interface PriceCalculator {
//		public double calculatePrice();
//	}
////    Map<Movie.Type, Function<Integer, Double>> m;
    public double calculatePrice() {
//		m.get()
//    	return movie.getType().computePrice(daysRented);
		switch (movie.getType()) {
			case REGULAR: return calculateRegularPrice();
			case NEW_RELEASE: return calculateNewReleasePrice();
			case CHILDRENS: return calculateChildrenPrice();
			default:
				throw new IllegalStateException("JDD: Unexpected value: " + movie.getType());
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
