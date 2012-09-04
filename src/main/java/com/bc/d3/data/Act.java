package com.bc.d3.data;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Act {

	private boolean completed;
	private List<Quest> completedQuests;

	public boolean isCompleted() {
		return completed;

	}

	public List<Quest> getCompletedQuests() {
		return Collections.unmodifiableList(completedQuests);
	}

}
