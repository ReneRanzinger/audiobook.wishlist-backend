package com.github.reneranzinger.audiobook.wishlist.persist;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book_rating", schema = "test", uniqueConstraints = @UniqueConstraint(columnNames = {
        "rating_type", "rating_date", "book_id" }))
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_rating_id", nullable = false)
    private Long m_id;

    @Column(name = "rating_type", nullable = false, length = 16)
    private String m_type;

    @Column(name = "rating", nullable = false)
    private Double m_rating;

    @Column(name = "rating_date", nullable = false)
    private Date m_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book m_book;

    public Rating()
    {
        super();
    }

    public Rating(String a_type, Double a_rating, Date a_date)
    {
        super();
        this.m_type = a_type;
        this.m_rating = a_rating;
        this.m_date = a_date;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getType()
    {
        return this.m_type;
    }

    public void setType(String a_type)
    {
        this.m_type = a_type;
    }

    public Double getRating()
    {
        return this.m_rating;
    }

    public void setRating(Double a_rating)
    {
        this.m_rating = a_rating;
    }

    public Date getDate()
    {
        return this.m_date;
    }

    public void setDate(Date a_date)
    {
        this.m_date = a_date;
    }

    public Book getBook()
    {
        return this.m_book;
    }

    public void setBook(Book a_book)
    {
        this.m_book = a_book;
    }
}
