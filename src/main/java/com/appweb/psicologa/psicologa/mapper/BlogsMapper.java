package com.appweb.psicologa.psicologa.mapper;


import org.springframework.jdbc.core.RowMapper;
import com.appweb.psicologa.psicologa.model.Blogs;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogsMapper implements RowMapper<Blogs>{
    
    @Override
    public Blogs mapRow(ResultSet rs, int rowNum) throws SQLException{
        Blogs blogs = new Blogs();
        
        blogs.setIdBlogs(rs.getInt("IdBlog"));
        blogs.setTitolBlog(rs.getString("Titol"));
        blogs.setUrl(rs.getString("Ur"));
        blogs.setExtracteBlog(rs.getString("Extracte"));
        blogs.setIdUsuari(rs.getInt("IdUsuari"));
        blogs.setImgDestacadaBlog(rs.getString("ImatgeDestacada"));
        blogs.setTiupusBlog(rs.getString("Tipus"));

        return blogs;
    }
}
