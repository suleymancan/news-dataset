package com.clickbait.dataset.titleandsite;

import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Entity
@NoArgsConstructor
public class TitleAndSite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition="text", length=10485760)
	private String title;

	@Column(length = 1000)
	private String site;

	// 0: non-clickbait, 1: clickbait
	private Integer clickbait;

	TitleAndSite(String title, String site, Integer clickbait) {
		this.title = title;
		this.site = site;
		this.clickbait = clickbait;
	}
}
