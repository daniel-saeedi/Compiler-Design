int x;
class Bookstore {
    public initialize (int id) {
        self.id = id
        self.fp = self.setAvailableBooks
    }

    private int id;
    private Address address;
    private Book[100] books;
    private void setAvailableBooks() {
        Book book;
        int i
        i = 0;
        self.books.each do |book| {
            book = Book.new(1000 * i + (i / 2), i++);
            books[i - 1] = book;
        }
    }
    public bool isBookAffordable(int id, int maxPrice) {
         self.books.each do |book| {
            if(book.getId() == id) {
                if (book.getPrice() < maxPrice)
                    return true;
            }
        }
        return false;
    }

    public fptr<void -> void> fp;

}


class Book{
    private int price;
    private int id;
    public initialize (int price, int id) {
        self.price = price;
        self.id = id;
    }

    public int getId() {
        return self.id;
    }

    public int getPrice() {
        return self.price;
    }

}

class Page < Book {
    private int number


    public int getNumber(){
        number = x
        return number
    }

    private int printNumber(){
        print(x++)
    }
}

class Main {
    public initialize() {
        Bookstore bookstore;
        bookstore = Bookstore.new(4 / 1 && 5 + 20);
        bookstore.fp();
    }
}
