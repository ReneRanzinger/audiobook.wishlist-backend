package com.github.reneranzinger.audiobook.wishlist.persist;

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
@Table(name = "series_watchlist", schema = "test", uniqueConstraints = @UniqueConstraint(columnNames = {
        "account_id", "series_id" }))
public class SeriesWatchList
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_watchlist_id", nullable = false)
    private Long m_id;

    @Column(name = "current_order_id", nullable = false)
    private Integer m_currentOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account m_account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series m_series;

    public SeriesWatchList()
    {
        super();
    }

    public SeriesWatchList(Integer a_currentOrder)
    {
        super();
        this.m_currentOrder = a_currentOrder;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public Integer getCurrentOrder()
    {
        return this.m_currentOrder;
    }

    public void setCurrentOrder(Integer a_currentOrder)
    {
        this.m_currentOrder = a_currentOrder;
    }

    public Account getAccount()
    {
        return this.m_account;
    }

    public void setAccount(Account a_account)
    {
        this.m_account = a_account;
    }

    public Series getSeries()
    {
        return this.m_series;
    }

    public void setSeries(Series a_series)
    {
        this.m_series = a_series;
    }

}
