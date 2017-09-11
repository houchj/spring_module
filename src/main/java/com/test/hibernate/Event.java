package com.test.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity
public class Event {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private long id;

	@Column(name = "TITLE")
	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	private Date date;

	public Event(String title, Date date) {
		super();
		this.title = title;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}

}
