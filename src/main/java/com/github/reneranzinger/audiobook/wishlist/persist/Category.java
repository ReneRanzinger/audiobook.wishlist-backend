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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "category", schema = "test", uniqueConstraints = @UniqueConstraint(columnNames = {
        "category", "subcategory" }))
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long m_id;

    @Column(name = "category", nullable = false, length = 64)
    private String m_category;

    @Column(name = "subcategory", nullable = false, length = 64)
    private String m_subCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_category", fetch = FetchType.LAZY)
    private List<Book> m_books;

    public Category()
    {
        super();
    }

    public Category(String a_category, String a_subCategory)
    {
        super();
        this.m_category = a_category;
        this.m_subCategory = a_subCategory;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getCategory()
    {
        return this.m_category;
    }

    public void setCategory(String a_category)
    {
        this.m_category = a_category;
    }

    public String getSubCategory()
    {
        return this.m_subCategory;
    }

    public void setSubCategory(String a_subCategory)
    {
        this.m_subCategory = a_subCategory;
    }

    public List<Book> getBooks()
    {
        return this.m_books;
    }

    public void setBooks(List<Book> a_books)
    {
        this.m_books = a_books;
    }
}
