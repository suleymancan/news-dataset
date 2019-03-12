package com.clickbait.dataset.newscopy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created on March, 2019
 *
 * @author suleymancan
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsCopy {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 1000)
	private String site;

	@Column(columnDefinition="text", length=10485760)
	private String title;

	@Column(columnDefinition="text", length=10485760)
	private String text;
	@Column(length = 1000)
	private String url;
	@Column(length = 1000)
	private String mainImage;
	@Column(length = 1000)
	private String published;

	// 0: non-clickbait, 1: clickbait
	private Integer clickbait;

}
