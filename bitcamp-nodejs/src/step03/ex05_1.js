// 주제: 여러 개의 요청 처리하기 - 회원 목록조회/등록/변경/삭제하기
// [실행 URL]
// => http://localhost:8000/member/delete?id=user100
// [출력 결과]
// 삭제 성공입니다.


const http = require('http')
const url = require('url')
const mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 10,
    host: '13.209.35.254', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});


const server = http.createServer((req, res) => {
    var urlInfo = url.parse(req.url, true);
    
    if (urlInfo.pathname === '/favicon.ico') {
        res.end();
        return;
    }
            
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    if (urlInfo.pathname === '/member/list') {
        var pageNo = 1;
        var pageSize = 3;
        
        if (urlInfo.query.pageNo) {
            pageNo = parseInt(urlInfo.query.pageNo)
        }
        if (urlInfo.query.pageSize) {
            pageSize = parseInt(urlInfo.query.pageSize)
        }
        
        var startIndex = (pageNo - 1) * pageSize;
        
        pool.query('select mid, email from pms2_member limit ?, ?',
                [startIndex, pageSize],
                function(err, results) {
            if (err) {
                res.end('DB 조회 중 예외 발생!')
                return;
            }
            
            for (var row of results) {
                res.write(`${row.email}, ${row.mid}\n`);
            }
            res.end();
        });
        
    } else if (urlInfo.pathname === '/member/add') {
        pool.query(
                'insert into pms2_member(mid,email,pwd)\
                values(?, ?, password(?))',
            [urlInfo.query.id, urlInfo.query.email, urlInfo.query.password],
            function(err, results) {
                if (err) {
                    res.end('데이터 처리 중 예외 발생!')
                    return;
                }
                
                res.write('등록성공!\n')
                res.end();
        });
        
    } else if (urlInfo.pathname === '/member/update') {
        pool.query(
                'update pms2_member set\
                 email=?,\
                 pwd=?\
                 where mid=?',
            [urlInfo.query.email,
             urlInfo.query.password,
             urlInfo.query.id],
            function(err, results) {
                if (err) {
                    res.end('DB 조회 중 예외 발생!')
                    return;
                }
                
                res.write('변경 성공!')
                res.end();
        });
        
    } else if (urlInfo.pathname === '/member/delete') {
        pool.query('delete from pms2_member where mid=?',
            [urlInfo.query.id],
            function(err, results) {
                if (err) {
                    res.end('DB 조회 중 예외 발생!')
                    return;
                }
                
                res.write('삭제 성공!')
                res.end();
        });
    } else {
        res.end('해당 URL을 지원하지 않습니다!');
        return;
    }
    
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









