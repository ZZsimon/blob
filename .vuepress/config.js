module.exports = {
    title: 'FE BLOB',
    description: "我是描述...",

    themeConfig: {
        nav: [
            { text: '首页', link: '/' },
            { text: '前端技术', link: '/fe/' },
            { text: 'HTTP', link: '/http/' },
            { text: 'Nginx', link: '/nginx/' },
            { text: 'GitHub', link: 'https://github.com/ZZsimon/blob' }
        ],
        sidebar: {
            '/fe/': [
                '',
                {
                    title: 'JavaScript',   // 必要的
                    children: [
                        '/fe/js/decorator',
                        '/fe/js/promise',
                    ]
                },
            ],

            '/http/': [
                '',
            ],
            '/nginx/': [
                '',
            ],
        }
    }
}