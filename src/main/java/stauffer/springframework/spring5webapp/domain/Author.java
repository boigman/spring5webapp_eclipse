package stauffer.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

/*
 * Created by Dave Stauffer - 5/7/2020
*/
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authors")
//	@JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"),
//			inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Book> books = new HashSet<>();

	public Author() {
		
	}

	public Author(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}


}
