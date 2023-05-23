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
@Table(name = "book_wishlist", schema = "test", uniqueConstraints = @UniqueConstraint(columnNames = {
        "account_id", "book_id" }))
public class BookWishList
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_wishlist_id", nullable = false)
    private Long m_id;

    @Column(name = "priority", nullable = false)
    private Integer m_priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account m_account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book m_book;

    public BookWishList()
    {
        super();
    }

    public BookWishList(Integer a_priority)
    {
        super();
        this.m_priority = a_priority;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public Integer getPriority()
    {
        return this.m_priority;
    }

    public void setPriority(Integer a_priority)
    {
        this.m_priority = a_priority;
    }

    public Account getAccount()
    {
        return this.m_account;
    }

    public void setAccount(Account a_account)
    {
        this.m_account = a_account;
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
