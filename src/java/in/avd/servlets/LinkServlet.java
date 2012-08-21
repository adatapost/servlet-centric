package in.avd.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LinkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        ArrayList<String> songsList = (ArrayList<String>) session.getAttribute("songsList");

        if (songsList == null) {
            songsList = new ArrayList<String>();
            session.setAttribute("songsList", songsList);
        }
        request.getRequestDispatcher("/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String link = request.getParameter("song_link");
        String cmd = request.getParameter("cmd");

        HttpSession session = request.getSession();
        ArrayList<String> songsList = (ArrayList<String>) session.getAttribute("songsList");

        if (songsList == null) {
            songsList = new ArrayList<String>();
            session.setAttribute("songsList", songsList);
        }
        if (cmd.equals("Add")) {
            songsList.add(link);
        }

        request.getRequestDispatcher("/show.jsp").forward(request, response);
    }
}
