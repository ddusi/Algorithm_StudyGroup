
public class Question2 {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i].length() < phone_book[i + 1].length()) {
				if (phone_book[i].equals(phone_book[i + 1].substring(0, phone_book[i].length())))
					return false;
			} else {
				if (phone_book[i + 1].equals(phone_book[i].substring(0, phone_book[i + 1].length())))
					return false;
			}
		}
		return true;
	}
}
