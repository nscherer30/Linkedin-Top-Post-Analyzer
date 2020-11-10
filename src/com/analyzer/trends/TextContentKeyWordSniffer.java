package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextContentKeyWordSniffer extends TrendFinder {

	public TextContentKeyWordSniffer() throws IOException {
	}

	/**
	 * Returns a list of most useful text keywords based on users past top posts.
	 * <p>
	 * Anaylzes the top posts by cross referencing the most common words used.
	 * These will be referred to as 'keywords' and the assumption is that these
	 * keywords positively increased their posts reach according to LinkedIns algorithm.
	 * @param  numOfResultsToFind  the maximum number of results to find
	 * @return      the list of String results
	 * @see         List
	 */
	@Override
	public List<String> findTrend(int numOfResultsToFind) {
		// Find most used verbs and nouns

		// Sort result of most used keywords

		// Return sub list of result according to limit
		return null;
	}

	private List<Post> filterTextPosts(){
		return null;
	}
}
