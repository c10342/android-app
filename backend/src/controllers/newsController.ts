import { Request, Response } from 'express';
import { ApiResponse, HttpError } from '../types';

// 新闻列表项
interface NewsItem {
  avatar: string; // 用户头像
  title: string; // 标题
  name: string; // 名称
  cover: string; // 封面
  commentCount: number; // 评论数量
  likeCount: number; // 点赞数量
  favoriteCount: number; // 收藏数量
}

// 分页结果
interface PageResult<T> {
  list: T[];
  total: number;
  page: number;
  pageSize: number;
  totalPages: number;
}

// 模拟新闻数据
const mockNewsList: NewsItem[] = Array.from({ length: 36 }, (_, i) => ({
  avatar: `https://i.pravatar.cc/150?img=${(i % 70) + 1}`,
  title: `新闻标题 ${i + 1}`,
  name: `创作者 ${i + 1}`,
  cover: `https://picsum.photos/seed/news-${i + 1}/600/400`,
  commentCount: Math.floor(Math.random() * 500),
  likeCount: Math.floor(Math.random() * 2000),
  favoriteCount: Math.floor(Math.random() * 800),
}));

// 新闻播放列表分页查询
export const getNewsList = (
  req: Request,
  res: Response
): void => {
  const page = Math.max(1, Number(req.query.page) || 1);
  const pageSize = Math.max(1, Number(req.query.pageSize) || 10);

  const total = mockNewsList.length;
  const totalPages = Math.ceil(total / pageSize);
  const start = (page - 1) * pageSize;
  const list = mockNewsList.slice(start, start + pageSize);

  if (page > totalPages && total > 0) {
    throw new HttpError(400, `页码超出范围，共 ${totalPages} 页`);
  }

  const data: PageResult<NewsItem> = {
    list,
    total,
    page,
    pageSize,
    totalPages,
  };

  const response: ApiResponse<PageResult<NewsItem>> = {
    code: 200,
    message: '查询成功',
    data,
  };
  res.status(200).json(response);
};
