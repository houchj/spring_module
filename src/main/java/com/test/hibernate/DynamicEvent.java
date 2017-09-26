package com.test.hibernate;

import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicUpdate
public class DynamicEvent implements Serializable {

	private static final long serialVersionUID = 6960365450193985247L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String location;
	private Date date;

	public DynamicEvent() {
	}

	public DynamicEvent(String name, String location, Date date) {
		this.name = name;
		this.location = location;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event{" + "id=" + id + ", name='" + name + '\'' + ", location='" + location + '\'' + ", date=" + date
				+ '}';
	}
}
