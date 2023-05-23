package com.github.reneranzinger.audiobook.wishlist.persist;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reader", schema = "test")
public class Reader
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id", nullable = false)
    private Long m_id;

    @Column(name = "reader_name", nullable = false, length = 128, unique = true)
    private String m_name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "m_readers")
    private Set<Book> m_books = new HashSet<Book>();

    public Reader()
    {
        super();
    }

    public Reader(String a_name)
    {
        super();
        this.m_name = a_name;
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

    public Set<Book> getBooks()
    {
        return this.m_books;
    }

    public void setBooks(Set<Book> a_books)
    {
        this.m_books = a_books;
    }
}
