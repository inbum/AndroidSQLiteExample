package kr.co.sqliteexample;

class Post {
    public User user;
    public String text;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("user=").append(user.toString());
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
