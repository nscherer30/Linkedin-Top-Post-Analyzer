package com.analyzer.sniffer;

import com.analyzer.model.Post;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a "hashtag" Sniffer. Searches for the most
 * used hashtags in a user's most popular posts'.
 *
 * @author Jason Zhang
 * @author Nick Scherer
 * @version 1.0
 * @since 1.0
 */
public class HashtagSniffer extends Sniffer {
	// max appearances of a hashtags
	private int max = 0;

	/**
	 * Creates a HashtagSniffer object.
	 */
	public HashtagSniffer() throws IOException {
		super();
	}

	/**
	 * Returns a list of Hashtag trend results according to users top posts.
	 * This implementation specific method analyzes the top user posts.
	 * It then will determine useful information for the user to know
	 * and returns a list of Hashtag Strings that appears most often
	 * as a result for future output.
	 *
	 * @param numOfResultsToFind the maximum number of results to find
	 * @return the list of String results
	 * @see List
	 */
	@Override
	public List<String> findTrend(int numOfResultsToFind) throws IOException {
		return getHashtagTrend(getHashtagList());
	}

	/**
	 * Returns a list of String Hashtags from all selected top posts
	 * and returns a list of all Hashtags within supplement posts
	 * as a input for getHashtagTrend().
	 *
	 * @return the list of all the String Hashtags from supplement posts as results
	 * @see List
	 */
	public List<String> getHashtagList() {
		// sorting list, return a list of List<String> of hashtags for the top ${numOfResultsToFind} post/s.
		List<List<String>> list = getUserTopPostsFilteredByALimit().stream()
				.map(Post::getListOfHashTags)
				.collect(Collectors.toList());
		// flatten list into an list of string of all hashtags retrived.
		List<String> listOfHashtags = list.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		return listOfHashtags;
	}

	/**
	 * Returns a list of Hashtags that appears most often from supplement posts
	 *
	 * @return the list of most popular Hashtags from supplement posts as results
	 * @see List
	 */
	public List<String> getHashtagTrend(List<String> listOfHashtags) {
		// Insert listOfHashtags into Map<Integer, String>
		Map<Integer, String> mod = new HashMap<>();

		// Finds the most frequently used hashtags
		getMostHashTagOccurrences(listOfHashtags, mod);

		int finalMax = max;
		List<String> modeOfHashtags = mod.entrySet().stream()
				.filter(c -> c.getKey() == finalMax)
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
		return modeOfHashtags;
	}

	/**
	 * Helper method to increment an occurrences in a map
	 * of the user's most used hashtags.
	 */
	private void getMostHashTagOccurrences(List<String> listOfHashtags, Map<Integer, String> mod) {
		for (int i = 0; i < listOfHashtags.size(); i++) {
			int count = 0;
			for (int j = 0; j < listOfHashtags.size(); j++) {
				if (listOfHashtags.get(i).equals(listOfHashtags.get(j))) {
					++count;
				}
			}
			// insert number of appearance as key, and the Hashtag itself as its value] into HashMap mod.
			mod.put(count, listOfHashtags.get(i));
		}

		// Find out the maximum appearances numbers.
		for (int count : mod.keySet()) {
			if (count > max) {
				max = count;
			}
		}
	}
}



