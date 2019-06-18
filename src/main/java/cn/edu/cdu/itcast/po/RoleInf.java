package cn.edu.cdu.itcast.po;

public class RoleInf {
    private Integer roleid;

    private String rolename;

    private String roledetail;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledetail() {
        return roledetail;
    }

    public void setRoledetail(String roledetail) {
        this.roledetail = roledetail == null ? null : roledetail.trim();
    }
}