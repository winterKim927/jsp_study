package news.domain;

import lombok.Data;

@Data
public class Comments {
	private int comments_idx;
	private News news;
	private String msg;
	private String author;
	private String writedate;
}
