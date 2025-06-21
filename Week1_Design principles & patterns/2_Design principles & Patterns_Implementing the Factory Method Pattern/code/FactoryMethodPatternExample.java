public class FactoryMethodPatternExample {
    interface Item {
        void info();
    }
    static class Pen implements Item {
        public void info() {
            System.out.println("Pen object created.");
        }
    }

    static class Notebook implements Item {
        public void info() {
            System.out.println("Notebook object created.");
        }
    }

    abstract static class ItemFactory {
        public abstract Item createItem();
    }
    static class PenFactory extends ItemFactory {
        public Item createItem() {
            return new Pen();
        }
    }

    static class NotebookFactory extends ItemFactory {
        public Item createItem() {
            return new Notebook();
        }
    }
    public static void main(String[] args) {
        ItemFactory penFactory = new PenFactory();
        Item item1 = penFactory.createItem();
        item1.info();

        ItemFactory notebookFactory = new NotebookFactory();
        Item item2 = notebookFactory.createItem();
        item2.info();
    }
}
