package ua.nure.orlovskyi.SummaryTask4.model;

import java.time.LocalDate;
import java.util.Date;

public class Passport {
	private Integer id;
	private String series;
	private LocalDate issue;
	
	
	public Passport(Integer id, String series, LocalDate issue) {
		super();
		this.id = id;
		this.series = series;
		this.issue = issue;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public LocalDate getIssue() {
		return issue;
	}
	public void setIssue(LocalDate issue) {
		this.issue = issue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issue == null) ? 0 : issue.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passport other = (Passport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issue == null) {
			if (other.issue != null)
				return false;
		} else if (!issue.equals(other.issue))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", series=" + series + ", issue=" + issue + "]";
	}

}
