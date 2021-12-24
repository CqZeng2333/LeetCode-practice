/**
 * Given n books and the i-th book has pages[i] pages. There are k persons to copy these books.
 *
 * These books list in a row and each person can claim a continous range of books. For example, one copier can copy the books from i-th to j-th continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
 *
 * They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
 *
 * Return the shortest time that the slowest copier spends.
 */
public class __437 {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }

        int start = Integer.MIN_VALUE, end = 0;
        for (int i = 0 ; i < pages.length; i++) {
            if (start < pages[i]) {
                start = pages[i];
            }
            end += pages[i];
        }

        int midTime;
        while (start < end - 1) {
            midTime = start + (end - start) / 2;
            if (peopleNeededToCopy(pages, midTime) <= k) {
                end = midTime;
            } else {
                start = midTime;
            }
        }

        if (peopleNeededToCopy(pages, start) <= k) {
            return start;
        } else {
            return end;
        }
    }

    public int peopleNeededToCopy(int[] pages, int maxTime) {
        int pNum = 1;
        int count = 0;

        int sumPages = 0;
        while (count < pages.length) {
            if (sumPages + pages[count] <= maxTime) {
                sumPages += pages[count];
                count++;
            } else {
                if (pages[count] > maxTime) {
                    return -1;
                } else {
                    pNum += 1;
                    sumPages = pages[count];
                    count++;
                }
            }
        }
        return pNum;
    }

    public static void main(String[] args) {
        __437 main = new __437();
        System.out.println(main.copyBooks(new int[]{3, 2, 4}, 3));
    }
}
