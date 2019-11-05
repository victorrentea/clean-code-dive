package videostore.horror;
public class Movie {

	enum Type {
		CHILDRENS, REGULAR, NEW_RELEASE;
	}
	private final String title;
	private final Type type;

	public Movie(String title, Type type) {
		this.title = title;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public String getTitle() {
		return title;
	};
}