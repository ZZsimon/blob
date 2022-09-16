const moment = require('moment');


module.exports = {
    theme: 'reco',
    title: 'Full Stack Blob',
    description: "我是描述...",
    base: '/blob/',
    themeConfig: {
        lastUpdated: '上次更新', // string | boolean
        nav: [
            { text: '首页', link: '/' },
            { text: '前端技术', link: '/fe/' },
            { text: 'HTTP', link: '/http/' },
            { text: 'Nginx', link: '/nginx/' },
            { text: '运维部署', link: '/deploy/' },
            { text: 'GitHub', link: 'https://github.com/ZZsimon/blob' }
        ],
        sidebar: {
            '/fe/': [
                '',
                {
                    title: 'JavaScript',
                    collapsable: false,
                    children: [
                        '/fe/js/promise',
                        '/fe/js/decorator',
                    ]
                },

                {
                    title: 'mode',
                    collapsable: false,
                    children: [
                        '/fe/designPatterns/observer',
                    ]
                },
            ],

            '/http/': [
                '',
            ],
            '/nginx/': [
                '',
            ],

            '/deploy/': [
                '',
                'githubActions',
                'ssh',
            ],
        }
    },

    plugins: [
        ['@vuepress-reco/vuepress-plugin-back-to-top', false],
        'cursor-effects',
        'dynamic-title',
        'go-top',

        [
            'vuepress-plugin-code-copy',
            {
                successText: '复制成功！'
            }
        ],
        [
            '@vuepress-reco/vuepress-plugin-kan-ban-niang',
            {
                theme: ['shizuku'],
                clean: true,
            }
        ],

        [
            '@vuepress/last-updated',
            {
                transformer: (timestamp) => {
                    moment.locale('zh-cn')
                    return moment(timestamp).fromNow()
                }
            }
        ],
    ]
}