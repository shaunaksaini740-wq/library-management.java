package library;
    public class Book {
        private int id;
        private String name;
        private String author;
        private String category;
        private boolean available;

        public Book(int id, String name, String author, String category) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.category = category;
            this.available = true;
        }

        public int getId() { 
            return id; 
        }
        public String getName() { 
            return name; 
        }
        public String getAuthor() { 
            return author; 
        }
        public String getCategory() { 
            return category; 
        }
        public boolean isAvailable() {
            return available; 
            }
        public void setAvailable(boolean available) { 
            this.available = available; 
        }

        @Override
        public String toString() {
            return id + " | " + name + " | " + author + " | " + category + " | " +
                (available ? "Available" : "Issued");
        }
    }
