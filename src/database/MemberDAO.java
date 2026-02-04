package database;
import models.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public boolean InsertMember(Member member) {
        String sql = "INSERT INTO members (name, age, email) " +
                "VALUES (?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, member.getName());
            statement.setInt(2, member.getAge());
            statement.setString(3, member.getEmail());

            int rowsInserted = statement.executeUpdate();
            statement.close();
            if (rowsInserted > 0) {
                System.out.println("Member inserted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error inserting member: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    public List<Member> getAllMembers(){
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members ORDER BY member_id";


        Connection conn = DatabaseConnection.getConnection();
        if(conn == null) return members;

        try{
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Member member = extractMemberFromResultSet(resultSet);
                members.add(member);
            }

            resultSet.close();
            statement.close();

            System.out.println("All members fetched successfully!");

            }catch(SQLException e){
                System.err.println("Error fetching members: " + e.getMessage());
            }finally {
                DatabaseConnection.closeConnection(conn);
            }

        return members;
    }

    public boolean updateMember(int memberId, Member member) {
        String sql = "UPDATE members SET name = ?, age = ?, email = ? WHERE member_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, member.getName());
            statement.setInt(2, member.getAge());
            statement.setString(3, member.getEmail());
            statement.setInt(4, memberId);

            int rowsUpdated = statement.executeUpdate();
            statement.close();
            if (rowsUpdated > 0) {
                System.out.println("Member updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error updating member: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    public boolean deleteMember(int memberId) {
        String sql = "DELETE FROM members WHERE member_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, memberId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();
            if (rowsDeleted > 0) {
                System.out.println("Member deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error deleting member: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    public Member searchById(int memberId) {
        String sql = "SELECT * FROM members WHERE member_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return null;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, memberId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Member member = extractMemberFromResultSet(resultSet);
                resultSet.close();
                statement.close();
                return member;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error searching member by ID: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return null;
    }

    public List<Member> searchByName(String name) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE name LIKE ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return members;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Member member = extractMemberFromResultSet(resultSet);
                members.add(member);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error searching members by name: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return members;
    }

    public List<Member> searchByAge(int age) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE age = ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return members;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, age);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Member member = extractMemberFromResultSet(resultSet);
                members.add(member);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error searching members by age: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return members;
    }

    private Member extractMemberFromResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");

        try {
            return new Member(name, age, email);
        } catch (IllegalArgumentException ex) {
            // If DB contains invalid data, fail with a clear message.
            throw new SQLException("Invalid member data in DB ч" +  ex);
        }
    }

}



