package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * HashtagSniffer, fist sorting list by number of views then by number of likes and lastly by number of comments.
 * then find the hashtag/s which appeared the most frequent.
 */

public class HashtagSniffer {
    private String dataFilePath;

    public HashtagSniffer(String dataFilePath) throws IOException {
        this.dataFilePath = dataFilePath;
    }

    public List<String> hashtagSniffer(int limit) throws IOException {

        LinkedInUserCSVReader reader = new LinkedInUserCSVReader(dataFilePath);
        List<Post> temp = reader.load();

        // sorting list, return a list of List<String> of hashtages for the top ${limit} post/s.
        List<List<String>> list = temp.stream()
                .sorted(Comparator.comparing(Post::getNumOfViews).reversed()
                        .thenComparing(Post::getNumOfLikes).reversed()
                        .thenComparing(Post::getNumOfComments).reversed()) // Sort list by number of views then by number of likes and lastly by number of comments
                .limit(limit) // limit outputs to limits that set by user. e.g. first 5.
                .map(Post::getListOfHashTags)
                .collect(Collectors.toList());

        // flatten list into an list of string of all hashtags retrived.
        List<String> listOfHashtags = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        //System.out.println(listOfHashtags);
        return listOfHashtags;
    }
}
