package com.github.reneranzinger.audiobook.wishlist.persist;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "test")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long m_id;

    @Column(name = "title", nullable = false, length = 128, unique = true)
    private String m_title;

    @Column(name = "url", nullable = false, length = 4096, unique = true)
    private String m_url;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String m_description;

    @Column(name = "audible_id", nullable = false, length = 16, unique = true)
    private String m_audibleId;

    @Column(name = "abridged", nullable = false)
    private Boolean m_abridged;

    @Column(name = "image_url", nullable = true, length = 4096)
    private String m_imageUrl;

    @Column(name = "language", nullable = true, length = 64)
    private String m_language;

    @Column(name = "date_published", nullable = false)
    private Date m_datePublished;

    @Column(name = "duration", nullable = false)
    private Integer m_duration;

    @Column(name = "series_order_id", nullable = true)
    private Integer m_seriesOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = true)
    private Series m_series;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_book", fetch = FetchType.LAZY)
    private List<BookWishList> m_bookWishList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_book", fetch = FetchType.LAZY)
    private List<Rating> m_ratings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category m_category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_reader", schema = "test", joinColumns = {
            @JoinColumn(name = "book_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "reader_id") })
    private Set<Reader> m_readers = new HashSet<Reader>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author", schema = "test", joinColumns = {
            @JoinColumn(name = "book_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "author_id") })
    private Set<Author> m_authors = new HashSet<Author>();

    public Book()
    {
        super();
    }

    public Book(String a_title, String a_url, String a_description, String a_audibleId,
            Boolean a_abridged, String a_imageUrl, Date a_datePublished, Integer a_duration)
    {
        super();
        this.m_title = a_title;
        this.m_url = a_url;
        this.m_description = a_description;
        this.m_audibleId = a_audibleId;
        this.m_abridged = a_abridged;
        this.m_imageUrl = a_imageUrl;
        this.m_datePublished = a_datePublished;
        this.m_duration = a_duration;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getTitle()
    {
        return this.m_title;
    }

    public void setTitle(String a_title)
    {
        this.m_title = a_title;
    }

    public String getUrl()
    {
        return this.m_url;
    }

    public void setUrl(String a_url)
    {
        this.m_url = a_url;
    }

    public String getDescription()
    {
        return this.m_description;
    }

    public void setDescription(String a_description)
    {
        this.m_description = a_description;
    }

    public String getAudibleId()
    {
        return this.m_audibleId;
    }

    public void setAudibleId(String a_audibleId)
    {
        this.m_audibleId = a_audibleId;
    }

    public Boolean getAbridged()
    {
        return this.m_abridged;
    }

    public void setAbridged(Boolean a_abridged)
    {
        this.m_abridged = a_abridged;
    }

    public String getImageUrl()
    {
        return this.m_imageUrl;
    }

    public void setImageUrl(String a_imageUrl)
    {
        this.m_imageUrl = a_imageUrl;
    }

    public Date getDatePublished()
    {
        return this.m_datePublished;
    }

    public void setDatePublished(Date a_datePublished)
    {
        this.m_datePublished = a_datePublished;
    }

    public Integer getDuration()
    {
        return this.m_duration;
    }

    public void setDuration(Integer a_duration)
    {
        this.m_duration = a_duration;
    }

    public Integer getSeriesOrder()
    {
        return this.m_seriesOrder;
    }

    public void setSeriesOrder(Integer a_seriesOrder)
    {
        this.m_seriesOrder = a_seriesOrder;
    }

    public Series getSeries()
    {
        return this.m_series;
    }

    public void setSeries(Series a_series)
    {
        this.m_series = a_series;
    }

    public List<BookWishList> getBookWishList()
    {
        return this.m_bookWishList;
    }

    public void setBookWishList(List<BookWishList> a_bookWishList)
    {
        this.m_bookWishList = a_bookWishList;
    }

    public List<Rating> getRatings()
    {
        return this.m_ratings;
    }

    public void setRatings(List<Rating> a_ratings)
    {
        this.m_ratings = a_ratings;
    }

    public Category getCategory()
    {
        return this.m_category;
    }

    public void setCategory(Category a_category)
    {
        this.m_category = a_category;
    }

    public Set<Reader> getReaders()
    {
        return this.m_readers;
    }

    public void setReaders(Set<Reader> a_readers)
    {
        this.m_readers = a_readers;
    }

    public Set<Author> getAuthors()
    {
        return this.m_authors;
    }

    public void setAuthors(Set<Author> a_authors)
    {
        this.m_authors = a_authors;
    }

    public String getLanguage()
    {
        return this.m_language;
    }

    public void setLanguage(String a_language)
    {
        this.m_language = a_language;
    }
}
