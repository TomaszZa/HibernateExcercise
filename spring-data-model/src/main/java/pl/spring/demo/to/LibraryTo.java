package pl.spring.demo.to;

public class LibraryTo {
	private Long id;
	private String name;

	public LibraryTo() {
	}

	public LibraryTo(Long id, String title, String authors) {
		this.id = id;
		this.name = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return name;
	}

	public void setTitle(String name) {
		this.name = name;
	}
}
