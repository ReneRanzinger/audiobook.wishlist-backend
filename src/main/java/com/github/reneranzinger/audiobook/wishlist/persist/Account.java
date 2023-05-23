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
@Table(name = "account", schema = "test")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long m_id;

    @Column(name = "account_name", nullable = false, length = 64, unique = true)
    private String m_name;

    @Column(name = "hash", nullable = false, length = 128, unique = true)
    private String m_hash;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_account", fetch = FetchType.LAZY)
    private List<SeriesWatchList> m_seriesWatchList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_account", fetch = FetchType.LAZY)
    private List<BookWishList> m_bookWishList;

    public Account()
    {
        super();
    }

    public Account(String a_name, String a_hash)
    {
        super();
        this.m_name = a_name;
        this.m_hash = a_hash;
    }

    public String getHash()
    {
        return this.m_hash;
    }

    public void setHash(String a_hash)
    {
        this.m_hash = a_hash;
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

    public List<SeriesWatchList> getSeriesWatchList()
    {
        return this.m_seriesWatchList;
    }

    public void setSeriesWatchList(List<SeriesWatchList> a_seriesWatchList)
    {
        this.m_seriesWatchList = a_seriesWatchList;
    }

    public List<BookWishList> getBookWishList()
    {
        return this.m_bookWishList;
    }

    public void setBookWishList(List<BookWishList> a_bookWishList)
    {
        this.m_bookWishList = a_bookWishList;
    }
}
