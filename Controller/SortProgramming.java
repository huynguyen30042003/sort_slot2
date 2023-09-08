
package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Element;
import View.Menu;

public class SortProgramming extends Menu<String> {

    static String[] option = { "search", "sort", "Exit" };

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SortProgramming(Element element) {
        super("All option", option);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    Element element = new Element();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String mcSearch[] = new String[] { "Linear Search", "Binary Search", "Exit" };

                Menu sortMenu = new Menu("Searching", mcSearch) {
                    @Override
                    public void execute(int choice) {
                        algorithm.buddleSort(array);
                        System.out.println("array: ");
                        library.display(array);
                        System.out.println(" Searching by" + mcSearch[n]);
                        int numberSearch;
                        switch (choice) {
                            case 1:
                                numberSearch = library.getInt("Enter the number to find ", 1, 100);
                                System.out.println(algorithm.linerSearch(array, numberSearch));

                                break;
                            case 2:
                                numberSearch = library.getInt("Enter the number to find ", 1, 100);
                                System.out.println(algorithm.binarySearch(array, numberSearch));
                                break;
                            case 3:
                                System.exit(0);
                                break;
                        }
                    }

                };
                sortMenu.runSearch();
                break;
            case 2:
                String[] mcSort = { "Buddle Sort", "Quick Sort", "Exit" };

                Menu searchMenu = new Menu("sort", mcSort) {
                    @Override
                    public void execute(int choice) {
                        System.out.println("Unsorted array: ");
                        library.display(array);
                        switch (choice) {
                            case 1:
                                algorithm.buddleSort(array);
                                System.out.println("\nSorted array by Buddle Sort: ");
                                library.display(array);
                                System.out.println("");
                                System.exit(0);
                                break;
                            case 2:
                                algorithm.quickSort(array, 0, size_array - 1);
                                System.out.println("\nSorted array by Quick Sort: ");
                                library.display(array);
                                System.out.println("");
                                System.exit(0);
                                break;
                            case 3:
                                System.exit(0);
                                break;
                        }
                        SortProgramming SP = new SortProgramming(element);
                        SP.run();
                    }
                };
                searchMenu.run();
                break;
            case 3:
                break;

        }
    }
}
