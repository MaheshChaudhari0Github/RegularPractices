package Com.Book;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

public class App {
	public static String addbook(Session s, Transaction T) {
		System.out.println("Enter the Book Id");
		Scanner sc1 = new Scanner(System.in);
		int B_id = sc1.nextInt();

		System.out.println("Enter the Book Name");
		Scanner sc2 = new Scanner(System.in);
		String B_Name = sc2.nextLine();

		System.out.println("Enter the Author Name");
		Scanner sc3 = new Scanner(System.in);
		String A_Name = sc3.nextLine();

		System.out.println("Enter the Price");
		Scanner sc4 = new Scanner(System.in);
		int Price = sc4.nextInt();

		Book b = new Book();
		b.setB_id(B_id);
		b.setB_Name(B_Name);
		b.setA_Name(A_Name);
		b.setPrice(Price);
		s.save(b);
		T.commit();

		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		return "Book is Added";
	}

	public static String updatebook(Session s, Transaction T) {
		Scanner sc01 = new Scanner(System.in);
		System.out.println("Enter the Book id");
		int B_id = sc01.nextInt();
		System.out.println("Enter the Updated Price");
		int Price = sc01.nextInt();
		Book b1 = (Book) s.get(Book.class, B_id);
		b1.setPrice(Price);
		T.commit();
		s.close();
		sc01.close();
		return "Book is upadted";
	}

	public static String deletebook(Session s, Transaction T) {
		Scanner sc02 = new Scanner(System.in);
		System.out.println("Enter the Book id");
		int B_id = sc02.nextInt();
		Book b2 = (Book) s.load(Book.class, B_id);
		s.delete(b2);
		T.commit();
		s.close();
		sc02.close();
		return "Book is Deleted ";
	}
	/*
	 * public static String ShowBookList(Session s,Transaction T) { Query query =
	 * s.createQuery("From BOOK_I"); List<BOOK_I> books = query.list(); for(BOOK_I
	 * b1:books) { System.out.println("Book ISBN No: "+b1.getISBN() +
	 * " Book Name: "+b1.getName()+
	 * " Author Name: "+b1.getAuthor()+" Book Price: "+b1.getPrice()); } return
	 * "ALL List is here"; }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Project is Started");

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Book.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction T = s.beginTransaction();

		System.out.println("Enter the Option 1.Add Book  2.Update Book   3.Delete Book   4.Show Book List");
		Scanner sq01 = new Scanner(System.in);
		int Option = sq01.nextInt();
		switch (Option) {
		case 1:
			System.out.println(addbook(s, T));
			break;
		case 2:
			System.out.println(updatebook(s, T));
			break;
		case 3:
			System.out.println(deletebook(s, T));
			break;
		// case 4 : System.out.println(ShowBookList(s,T));
		}
		sq01.close();
	}
}
