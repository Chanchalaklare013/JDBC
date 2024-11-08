import java.sql.*;
 class Employeecrudd 
{
    public static Connection connect()
    {
        String url="jdbc:mysql://localhost:3306/company3";
        String user="root";
        String password="2004";
        Connection conn=null;
        try
        {
            conn=DriverManager.getConnection(url,user,password);
            System.out.println("connection successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public  void insert(int id,String name,String department,double salary) throws SQLException
    {
        String sql="insert into Employee(id,name,department,salary)value(?,?,?,?)";

        try(Connection conn=Employeecrudd.connect())
        {
            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,department);
            st.setDouble(4,salary);
            st.executeUpdate();
            System.out.println("insertion done");
            conn.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();        
        }
    }
    public void retrieve()
    {
        String sql="select *from Employee";

        try(Connection conn=Employeecrudd(sql))
        {
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String department=rs.getString("department");
            Double salary=rs.getDouble("salary");

            System.out.println("id:"+id+" name:"+name+" department:"+department+" salary:"+salary);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private Connection Employeecrudd(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Employeecrudd'");
    }
    public void update(int id,String name,String department,double salary) throws SQLException
    {
        String sql="update Employee set id=?,name=?,department=?,salary=? where id=?";
        try(Connection conn=Employeecrudd.connect())
        {
            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,department);
            st.setDouble(4, salary);

            st.executeUpdate();
            System.out.println("user updated successfully");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException
    {
        String sql="delete from Employee where id=?";
        try(Connection conn=Employeecrudd.connect())
        {
            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("deletion successfully");

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

class Driver 
{
    public static void main(String []args)throws SQLException
    {
        Employeecrudd cd=new Employeecrudd();
        cd.insert(2, "priyal","sales", 25000.00);

        cd.retrieve();
        cd.update(2, "priyal", "sales", 25000.00);
        cd.delete(1);
    }
}
