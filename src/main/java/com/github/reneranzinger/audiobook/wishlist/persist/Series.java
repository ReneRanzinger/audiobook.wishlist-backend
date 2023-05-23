package com.github.reneranzinger.audiobook.wishlist.persist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "series", schema = "test")
public class Series
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id", nullable = false)
    private Long m_id;

    @Column(name = "series_name", nullable = false, length = 128, unique = true)
    private String m_name;

    @Column(name = "url", nullable = false, length = 4096, unique = true)
    private String m_url;

    @Column(name = "audible_id", nullable = false, length = 16, unique = true)
    private String m_audibleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_series", fetch = FetchType.LAZY)
    private List<SeriesWatchList> m_seriesWatchList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_series", fetch = FetchType.LAZY)
    private List<Book> m_books;

    public Series()
    {
        super();
    }

    public Series(String a_name, String a_audibleId, String a_url)
    {
        super();
        this.m_name = a_name;
        this.m_url = a_url;
        this.m_audibleId = a_audibleId;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getName()
    {
        return this.m_name;
    }

    public void setName(String a_name)
    {
        this.m_name = a_name;
    }

    public String getUrl()
    {
        return this.m_url;
    }

    public void setUrl(String a_url)
    {
        this.m_url = a_url;
    }

    public List<SeriesWatchList> getSeriesWatchList()
    {
        return this.m_seriesWatchList;
    }

    public void setSeriesWatchList(List<SeriesWatchList> a_seriesWatchList)
    {
        this.m_seriesWatchList = a_seriesWatchList;
    }

    public List<Book> getBooks()
    {
        return this.m_books;
    }

    public void setBooks(List<Book> a_books)
    {
        this.m_books = a_books;
    }

    public String getAudibleId()
    {
        return this.m_audibleId;
    }

    public void setAudibleId(String a_audibleId)
    {
        this.m_audibleId = a_audibleId;
    }
}
