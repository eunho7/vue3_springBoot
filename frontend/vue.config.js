module.exports = {
  devServer: {
    proxy: {
      '/': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: {
          '^/': ''
        },
        ws: false // WebSocket 연결을 사용하지 않도록 설정
      }
    }
  }
}