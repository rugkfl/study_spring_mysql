<%@ page import="java.util.HashMap, java.util.ArrayList, com.example.co_templates.utils.Paginations" %>

    <!DOCTYPE html>
    <html lang="en">

        <!-- header -->
        <%@include file="/WEB-INF/views/templates/header.jsp" %>

    <body>

        <!-- Menu -->
        <%@include file="/WEB-INF/views/templates/navigator.jsp" %>

        <!-- Main Content -->
        <form action="/q/r/board/list_pagination" method="get">
            <div class="container mt-4">
                <div class="row">
                    <div class="col-md-8">
                        <h2>Search</h2>
                        <% HashMap dataMap=(HashMap) request.getAttribute("dataMap"); 
                        String search=(String) dataMap.getOrDefault("search", "" ); 
                        String searchType = (String) dataMap.getOrDefault("searchType", "");
                        %>
                            <div class="input-group mb-3">
                                <!-- 셀렉트 박스 추가 -->
                                <select class="form-select" id="searchType" name="searchType">
                                    <option selected>Choose...</option>
                                    <% 
                                        if(searchType.equals("TITLE")) {
                                    %>
                                    <option selected value="TITLE">TITLE</option>
                                    <option value="CONTENTS">CONTENTS</option>
                                    <option value="WRITER_ID">WRITER_ID</option>
                                    <%
                                    } else if (searchType.equals("CONTENTS")) {
                                    %>
                                    <option value="TITLE">TITLE</option>
                                    <option selected value="CONTENTS">CONTENTS</option>
                                    <option value="WRITER_ID">WRITER_ID</option>
                                    <% 
                                    } else if (searchType.equals("WRITER_ID")) {
                                    %> 
                                    <option value="TITLE">TITLE</option>
                                    <option value="CONTENTS">CONTENTS</option>
                                    <option selected value="WRITER_ID">WRITER_ID</option>
                                    <%
                                    } else {
                                    %>
                                    <option value="TITLE">TITLE</option>
                                    <option value="CONTENTS">CONTENTS</option>
                                    <option value="WRITER_ID">WRITER_ID</option> 
                                    <%
                                    }
                                    %>  
                                </select>
                                <input type="text" class="form-control" name="search" value="<%= search %>"
                                    placeholder="Search..." id="keydownEnter">
                                <button class="btn btn-primary">Go</button>
                                <button class="btn btn-danger">Delete</button>
                            </div>
                    </div>
                </div>
                <div class="col-12">
                    <table class="table">
                        <thead>
                            <th>PK_BOARDS</th>
                            <th>TITLE</th>
                            <th>CONTENTS</th>
                            <th>WRITER_ID</th>
                            <th>CREATE_DATE</th>
                            <th>PARENT_BOARDS</th>
                        </thead>
                        <tbody>
                            <% HashMap result=(HashMap) request.getAttribute("result"); ArrayList itemList=(ArrayList)
                                result.get("resultList"); for(Object obj : itemList) { HashMap record=(HashMap) obj ; %>
                                <tr>
                                    <td>
                                        <input type="checkbox" class="form-check-input" name="deleteIds"
                                            value='<%= record.get("PK_BOARDS") %>'>
                                    </td>
                                    <td>
                                        <%= record.get("PK_BOARDS") %>
                                    </td>
                                    <td>
                                        <%= record.get("TITLE") %>
                                    </td>
                                    <td>
                                        <%= record.get("CONTENTS") %>
                                    </td>
                                    <td>
                                        <%= record.get("WRITER_ID") %>
                                    </td>
                                    <td>
                                        <%= record.get("CREATE_DATE") %>
                                    </td>
                                    <td>
                                        <%= record.get("PARENT_BOARDS") %>
                                    </td>
                                </tr>
                                <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Pagination with buttons and query parameters -->
            <% Paginations paginations=(Paginations) result.get("paginations"); %>
                <nav aria-label="Page navigation">
                    <div>Total Count : <%=paginations.getTotalCount() %>
                    </div>
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <button class="page-link" type="submit" name="currentPage"
                                value="<%= paginations.getPreviousPage() %>">Previous</button>
                        </li>
                        <% for(int i=paginations.getBlockStart(); i <=paginations.getBlockEnd(); i++){ %>
                            <li class="page-item">
                                <button class="page-link" type="submit" name="currentPage" value="<%= i %>">
                                    <%= i %>
                                </button>
                            </li>
                            <% } %>
                                <li class="page-item">
                                    <button class="page-link" type="submit" name="currentPage"
                                        value="<%= paginations.getNextPage() %>">Next</button>
                                </li>
                    </ul>
                </nav>
        </form>

                 <!-- Footer -->
                 <%@include file="/WEB-INF/views/templates/footer.jsp" %>
    </body>

    </html>