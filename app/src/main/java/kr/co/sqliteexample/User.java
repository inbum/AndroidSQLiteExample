package kr.co.sqliteexample;

class User {
    String userName;
    String profilePictureUrl;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", profilePictureUrl='").append(profilePictureUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
